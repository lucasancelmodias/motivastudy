package com.motivastudy.demo.repository;

import org.springframework.mail.SimpleMailMessage;

public interface EmailRepository {
	public void sendEmail(SimpleMailMessage email);
}