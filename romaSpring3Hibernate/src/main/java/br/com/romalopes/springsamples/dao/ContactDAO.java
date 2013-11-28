package br.com.romalopes.springsamples.dao;

import java.util.List;

import br.com.romalopes.springsamples.form.Contact;

public interface ContactDAO {
	
	public void addContact(Contact contact);
	public List<Contact> listContact();
	public void removeContact(Integer id);
}
