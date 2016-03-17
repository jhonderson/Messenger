package com.jhonacd.restfulexamples.messenger.resources;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jhonacd.restfulexamples.messenger.model.Message;
import com.jhonacd.restfulexamples.messenger.resources.beans.MessageFilterBean;
import com.jhonacd.restfulexamples.messenger.service.MessageService;

@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageResource {

	private MessageService messageService = new MessageService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages(@BeanParam MessageFilterBean pMessageFilterBean) {
		if (pMessageFilterBean.getYear() > 0) {
			return messageService.getAllMessagesByYear(pMessageFilterBean.getYear());
		}
		if (pMessageFilterBean.getStart() > 0 && pMessageFilterBean.getSize() > 0) {
			return messageService.getAllMessagesPaginated(pMessageFilterBean.getStart(), pMessageFilterBean.getSize());
		}
		return messageService.getAllMessages();
	}

	@POST
	public Message addMessage(Message pMessage) {
		return messageService.addMessage(pMessage);
	}

	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long pId, Message pMessage) {
		pMessage.setId(pId);
		return messageService.updateMessage(pMessage);
	}

	@DELETE
	@Path("/{messageId}")
	public Message deleteMessage(@PathParam("messageId") long pId) {
		return messageService.removeMessage(pId);
	}

	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") long pId) {
		return messageService.getMessage(pId);
	}

	@Path("/{messageId}/comments")
	public CommentResource getCommentResource() {
		return new CommentResource();
	}
}
