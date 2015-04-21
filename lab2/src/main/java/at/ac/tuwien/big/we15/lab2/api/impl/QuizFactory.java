package at.ac.tuwien.big.we15.lab2.api.impl;

import java.util.List;

import javax.servlet.ServletContext;

import at.ac.tuwien.big.we15.lab2.api.Avatar;
import at.ac.tuwien.big.we15.lab2.api.Category;
import at.ac.tuwien.big.we15.lab2.api.JeopardyFactory;
import at.ac.tuwien.big.we15.lab2.api.Player;
import at.ac.tuwien.big.we15.lab2.api.Question;

public class QuizFactory{

	private List<Category> categories;
	private Player enemy;
	private Player user;
	private int numberOfQuestions = 0; 
	private Question selected_question;
	
	public QuizFactory( ) { 
	}
	
	public void init(){
		user = new Player();
		user.setAvatar(Avatar.getRandomAvatar());
		enemy = new Player();
		enemy.setAvatar(Avatar.getOpponent(user.getAvatar()));
	}
	
	public void setCategories(List<Category> categories){
		this.categories = categories;
	} 

	public List<Category> getCategories(){
		return this.categories;
	}

	public Player getEnemy() {
		return enemy;
	}

	public void setEnemy(Player enemy) {
		this.enemy = enemy;
	}

	public Player getUser() {
		return user;
	}

	public void setUser(Player user) {
		this.user = user;
	}

	public int getNumberOfQuestions() {
		return numberOfQuestions;
	}

	/**
	 * 
	 * @param id question id 
	 * @return question identified by id; null if not found
	 */
	public Question getQuestion(int id) {
		for(Category cat : categories){
			for(Question q : cat.getQuestions()){
				if(q.getId() == id){
					return q;
				}
			}		
		}	
		return null;
	}

	public Question getSelected_question() {
		return selected_question;
	}

	public void setSelected_question(Question selected_question) {
		this.selected_question = selected_question;
	}
}
