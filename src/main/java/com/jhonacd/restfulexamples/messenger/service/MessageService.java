package com.jhonacd.restfulexamples.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.jhonacd.restfulexamples.messenger.database.DatabaseClass;
import com.jhonacd.restfulexamples.messenger.model.Message;

public class MessageService {

	private Map<Long, Message> messages = DatabaseClass.getMessages();

	public MessageService() {
		messages.put(1L, new Message(1, "Message 1", "jhonacd"));
		messages.put(2L, new Message(2, "Message 2", "jhonacd"));
	}

	public List<Message> getAllMessages() {
		return new ArrayList<Message>(messages.values());
	}

	public List<Message> getAllMessagesByYear(int pYear) {
		List<Message> messagesByYear = new ArrayList<Message>();
		Calendar calendar = Calendar.getInstance();
		for (Message message : messages.values()) {
			calendar.setTime(message.getCreated());
			if (calendar.get(Calendar.YEAR) == pYear) {
				messagesByYear.add(message);
			}
		}
		return messagesByYear;
	}

	public List<Message> getAllMessagesPaginated(int pStart, int pSize) {
		List<Message> messagesPaginated = new ArrayList<Message>(messages.values());
		if (pStart + pSize > messagesPaginated.size()) {
			return new ArrayList<Message>();
		}
		return messagesPaginated.subList(pStart, pStart + pSize);
	}

	public Message getMessage(long pId) {
		return messages.get(pId);
	}

	public Message addMessage(Message pMessage) {
		pMessage.setId(messages.size() + 1);
		messages.put(pMessage.getId(), pMessage);
		return pMessage;
	}

	public Message updateMessage(Message pMessage) {
		if (pMessage.getId() <= 0) {
			return null;
		}
		messages.put(pMessage.getId(), pMessage);
		return pMessage;
	}

	public Message removeMessage(long pId) {
		return messages.remove(pId);
	}
}
