package com.octopus.project.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "players", catalog = "public")
public class Player implements Serializable {

	private static final long serialVersionUID = -2650988756343860542L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int playerId;
	private String name;
	private boolean deleted;

	@OneToMany(mappedBy = "player")
	private Collection<Rating> playerRatings = new ArrayList<Rating>();

	@OneToMany(mappedBy = "sourcePlayer")
	private Collection<Rating> sourceRatings = new ArrayList<Rating>();

	public Player() {

	}

	public Player(String name) {
		super();
		this.name = name;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public Collection<Rating> getPlayerRatings() {
		return playerRatings;
	}

	public void setPlayerRatings(Collection<Rating> playerRatings) {
		this.playerRatings = playerRatings;
	}

	public Collection<Rating> getSourceRatings() {
		return sourceRatings;
	}

	public void setSourceRatings(Collection<Rating> sourceRatings) {
		this.sourceRatings = sourceRatings;
	}

}
