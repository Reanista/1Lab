package ru.WebSpring.Lab6.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

//   ������

// hours >= 18
// 0 .. 6  ������ ����
// 6 .. 12 ������ ����
// 12 ..18 ������ ����
// 18..23  ������ �����

@Component("userVM")
public class UserVM {
	
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Autowired
	private MessageSource messageSource;
	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}	
	

	public String getHello() {
		
		//return (getUserName() == null || getUserName().isEmpty()) ? "������!" : 
		//	String.format("������, %s!", getUserName());
		
		String hello = getMessageSource().getMessage("header_hello", null, Locale.getDefault());
		
		return (getUserName() == null || getUserName().isEmpty() ? hello :
			getMessageSource().getMessage("header_hello_username", 
					new Object[] {getUserName()}, Locale.getDefault()));
		
	}
	

}
