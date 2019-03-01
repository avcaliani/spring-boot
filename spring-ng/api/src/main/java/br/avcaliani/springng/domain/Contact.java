package br.avcaliani.springng.domain;

import lombok.Data;

import java.util.Objects;

/**
 * Contact Model.
 */
@Data
public class Contact {

    private String name;
    private String tag;
    private String github;
    private String gitlab;

    /**
     * Default Constructor.
     */
    public Contact() { }

    /**
     * Full Constructor.
     *
     * @param name   Contact Name.
     * @param tag    Tags.
     * @param github GitHub Link.
     * @param gitlab GitLab Link;
     */
    public Contact(String name, String tag, String github, String gitlab) {
        this.name = name;
        this.tag = tag;
        this.github = github;
        this.gitlab = gitlab;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(name, contact.name) &&
                Objects.equals(tag, contact.tag) &&
                Objects.equals(github, contact.github) &&
                Objects.equals(gitlab, contact.gitlab);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, tag, github, gitlab);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", tag='" + tag + '\'' +
                ", github='" + github + '\'' +
                ", gitlab='" + gitlab + '\'' +
                '}';
    }
}
