package com.seb.patientmanager.data.model;

public class Contact {

    private String name;

    private String email;

    private String message;

    public Contact() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Contact contact)) {
            return false;
        }

        if (getName() != null ? !getName().equals(contact.getName()) : contact.getName() != null) {
            return false;
        }
        if (getEmail() != null ? !getEmail().equals(contact.getEmail()) : contact.getEmail() != null) {
            return false;
        }

        return getMessage() != null ? getMessage().equals(contact.getMessage()) : contact.getMessage() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getMessage() != null ? getMessage().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
