package br.com.romalopes.springsamples.service;

import java.util.List;

import br.com.romalopes.springsamples.form.Contact;

public interface ContactService {
	
	public void addContact(Contact contact);
	public List<Contact> listContact();
	public void removeContact(Integer id);
}
