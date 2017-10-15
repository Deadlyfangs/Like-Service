package com.octopus.project.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "ratings", catalog = "public")
public class Rating implements Serializable {

	private static final long serialVersionUID = -7474226922862423507L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ratingId;
	private String rating;
	private Date rating_date;

	@ManyToOne
	@JoinColumn(name = "player_id", referencedColumnName = "playerId")
	private Player player;

	@ManyToOne
	@JoinColumn(name = "source_player_id", referencedColumnName = "playerId")
	private Player sourcePlayer;

	public Rating() {

	}

	public Rating(String rating) {
		super();
		this.rating = rating;
	}
	
	public Rating(String rating, Date ratingDate) {
		super();
		this.rating = rating;
		this.rating_date = ratingDate;
	}

	public int getRatingId() {
		return ratingId;
	}

	public void setRatingId(int ratingId) {
		this.ratingId = ratingId;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public Date getRatingDate() {
		return rating_date;
	}

	public void setRatingDate(Date rating_date) {
		this.rating_date = rating_date;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Player getSourcePlayer() {
		return sourcePlayer;
	}

	public void setSourcePlayer(Player sourcePlayer) {
		this.sourcePlayer = sourcePlayer;
	}

}
