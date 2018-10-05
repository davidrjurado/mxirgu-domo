package com.mxirgu.domo.bean;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import com.mxirgu.domo.bean.list.ListAction;
import com.mxirgu.domo.bean.list.ListButton;
import com.mxirgu.domo.bean.list.ListCell;
import com.mxirgu.domo.bean.list.ListColumn;
import com.mxirgu.domo.bean.list.ListConfiguration;
import com.mxirgu.domo.bean.list.ListRender;

@Component
@Entity
@XmlRootElement
@Table(name="users")
public class User {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Integer id;
	private String login;
	private String password;
	private String name;
	private String surname;
	private String role;
	private Boolean active = Boolean.TRUE;
	
	
	
	public User() {

	}
	
	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public User(Integer id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public static ListConfiguration listConfiguration () {
		
		ListConfiguration listConfiguration = new ListConfiguration();
		listConfiguration.setEntity(User.class.getName());
		
		ArrayList<ListButton> buttons = new ArrayList<ListButton>();
		buttons.add(new ListButton(ListAction.NEW,"/newUser"));
		buttons.add(new ListButton(ListAction.AUDITTRAIL,"/listAuditTrail"));
		listConfiguration.setButtonList(buttons);
		
		ArrayList<ListColumn> columns = new ArrayList<ListColumn>();
		columns.add(new ListColumn("ID", User_.ID, Boolean.TRUE, Boolean.TRUE));
		columns.add(new ListColumn("Name", User_.NAME, Boolean.TRUE, Boolean.TRUE));
		columns.add(new ListColumn("Surname", User_.SURNAME, Boolean.TRUE, Boolean.TRUE));
		columns.add(new ListColumn("Login", User_.LOGIN, Boolean.TRUE, Boolean.TRUE));
		columns.add(new ListColumn("Active", User_.ACTIVE, Boolean.TRUE, Boolean.TRUE));
		//Edit action
		columns.add(new ListColumn(null, null, Boolean.FALSE, Boolean.FALSE));
		//Delete action
		columns.add(new ListColumn(null, null, Boolean.FALSE, Boolean.FALSE));
				
		listConfiguration.setColumnsList(columns);
		
		return listConfiguration;
	}
	
	public ArrayList<ListCell> listRow () {
		ArrayList<ListCell> cell = new ArrayList<ListCell>();
		cell.add(new ListCell(ListRender.TEXT, this.getId()));
		cell.add(new ListCell(ListRender.TEXT, this.getName()));
		cell.add(new ListCell(ListRender.TEXT, this.getSurname()));
		cell.add(new ListCell(ListRender.TEXT, this.getLogin()));
		cell.add(new ListCell(ListRender.CHECKBOX, this.getActive()));
		cell.add(new ListCell(ListRender.EDIT_BUTTON, new StringBuffer("/editUser/").append(this.getId())));
		cell.add(new ListCell(ListRender.DELETE_BUTTON, new StringBuffer("/removeUser/").append(this.getId())));
		return cell;
			
	}
	

}
