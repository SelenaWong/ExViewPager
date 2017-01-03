
/**   
 * @Title: FilmHintEvent.java 
 * @Package: com.app.entity 
 * @Description: TODO
 * @author lenovo  
 * @date 2016年5月12日 下午1:50:14 
 * @version 1.3.1 
 */


package com.evangeline.exviewpager.event;


import com.evangeline.exviewpager.entity.Film;

/**
 * @Description 
 * @author Selena Wong
 * @date 2016年5月12日 下午1:50:14 
 * @version V1.3.1
 */

public class FilmEvent {
	
	private String hint=null;
	private Film film=null;
	public FilmEvent(){
		
	}
	public FilmEvent( String hint){
		this.hint = hint;
	}
	public FilmEvent(Film film,String hint){
		this.film = film;
		this.hint = hint;
	}

	/**
	 * @return hint
	 */
	
	public String getHint() {
		return hint;
	}

	
	/** 
	 * @param hint 要设置的 hint 
	 */
	
	public void setHint(String hint) {
		this.hint = hint;
	}
	
	/**
	 * @return film
	 */
	
	public Film getFilm() {
		return film;
	}
	
	/** 
	 * @param film 要设置的 film 
	 */
	
	public void setFilm(Film film) {
		this.film = film;
	}
}
