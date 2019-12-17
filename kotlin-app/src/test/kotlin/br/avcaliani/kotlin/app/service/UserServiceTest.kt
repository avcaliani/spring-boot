package br.avcaliani.kotlin.app.service

import br.avcaliani.kotlin.app.model.User
import br.avcaliani.kotlin.app.repository.UserRepository
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.BDDMockito.*
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class UserServiceTest {

    @Mock
    lateinit var repository: UserRepository

    @InjectMocks
    lateinit var service: UserService

    @Before
    fun init(): Unit {
        val me = User("1", "Anthony", "avcaliani@github.com")
        given(repository.save(any(User::class.java))).willReturn(me)
        given(repository.find(anyString())).willReturn(me)
        given(repository.findAll()).willReturn(listOf(me))
        doNothing().`when`(repository).deleteById(anyString())
    }

    @Test
    fun shouldSaveTest(): Unit = assertNotNull(service.save(User("1", "Anthony", "avcaliani@github.com")))

    @Test(expected = RuntimeException::class)
    fun saveUserEmptyNameTest(): Unit = assertNull(service.save(User("1", "", "")))

    @Test(expected = RuntimeException::class)
    fun saveUserEmptyEmailTest(): Unit = assertNull(service.save(User("1", "Anthony", "")))

    @Test
    fun shouldFindTest(): Unit = assertNotNull(service.find("1"))

    @Test
    fun shouldFindAllTest(): Unit = assertEquals(1, service.find().size)

    @Test
    fun shouldRemoveTest(): Unit = assertNotNull(service.remove("1"))

}