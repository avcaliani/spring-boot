package br.avcaliani.secureskeleton.user.services;

import br.avcaliani.secureskeleton.user.model.entities.User;

/**
 *
 */
public interface IUserService {

    /**
     *
     * @param user
     * @throws Exception
     */
    public User save(User user) throws Exception;

}
