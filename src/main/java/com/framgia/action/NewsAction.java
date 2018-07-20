package com.framgia.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.framgia.model.Category;
import com.framgia.model.City;
import com.framgia.model.Comment;
import com.framgia.model.News;
import com.framgia.model.NewsImage;
import com.framgia.model.UserFollowNews;

public class NewsAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private News news;
	private Integer id;
	private UserFollowNews userFollowNews;
	private List<City> cities;
	private List<Category> categories;
	private List<Comment> comments;
	private Comment comment;
	private String description;
	private Integer newsId;
	private List<String> tittles;
	private List<News> newses;
	private String keyword;
	private List<News> postList;

	public List<News> getPostList() {
		return postList;
	}

	public void setPostList(List<News> postList) {
		this.postList = postList;
	}

	public String saveOrUpdateNews() {

		if (getCurrentUser() == null)
			return LOGIN;

		if (!saveFiles())
			return ERROR;

		news.setStatus(1);
		postList = newsService.findNewsPost(getCurrentUser());
		news.setUser(getCurrentUser());

		List<NewsImage> newsImgs = new ArrayList<>();
		for (int i = 0; i < getMyFiles().size(); i++) {
			NewsImage newsImg = new NewsImage();
			newsImg.setName(getMyFilesFileName().get(i));
			newsImgs.add(newsImg);
		}

		news = newsService.saveOrUpdate(news, newsImgs);
		if (news != null)
			return SUCCESS;
		else
			return INPUT;
	}

	public String delnews() {
		if (getCurrentUser() == null)
			return LOGIN;
		if (newsService.removeMyNews(id))
			return SUCCESS;
		return ERROR;
	}

	public String index() {
		return SUCCESS;
	}

	public String showTittle() {
		tittles = new ArrayList<String>();
		newses = newsService.loadAll();
		newses.forEach(news -> tittles.add(news.getTittle().toLowerCase()));
		return SUCCESS;
	}

	public String addNews() {
		if (getCurrentUser() == null)
			return LOGIN;

		categories = categoryService.findAll();
		cities = cityService.findAll();
		return SUCCESS;
	}

	public String postList() {
		if (getCurrentUser() == null)
			return LOGIN;
		postList = newsService.findNewsPost(getCurrentUser());
		for (News news : postList) {
			news.setNewsImages(newsService.findImageByIdNews(news.getId()));
			news.setCategory(categoryService.findbyId(news.getCategory().getId()));
			news.setCity(cityService.findbyId(news.getCity().getId()));
		}

		return SUCCESS;
	}

	public String showDetailNews() {

		if (getCurrentUser() == null)
			return INPUT;
		news = newsService.findById(id);
		userFollowNews = userFollowNewsService.loadByUserIdAndNewsId(getCurrentUser().getId(), id);
		comments = new ArrayList<Comment>();
		comments = commentService.loadCommentByNewsId(id);
		for (int i = 0; i < comments.size(); i++) {
			if (userService.findById(comments.get(i).getUserAccount().getId()) != null) {
				comments.get(i).setUserAccount(userService.findById(comments.get(i).getUserAccount().getId()));
			}
		}
		return SUCCESS;
	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserFollowNews getUserFollowNews() {
		return userFollowNews;
	}

	public void setUserFollowNews(UserFollowNews userFollowNews) {
		this.userFollowNews = userFollowNews;
	}

	public void validate() {
		categories = categoryService.findAll();
		cities = cityService.findAll();

		try {
			if (StringUtils.isEmpty(news.getContent())) {
				addFieldError("news.content", getText("news.content.required"));
			}
			if (StringUtils.isEmpty(news.getPhoneNumber())) {
				addFieldError("news.phoneNumber", getText("news.phoneNumber.required"));
			}

			if (StringUtils.isEmpty(news.getTittle())) {
				addFieldError("news.tittle", getText("news.tittle.required"));
			}
			if (news.getPrice() == null) {
				addFieldError("news.price", getText("news.price.required"));
			}
			if (getMyFiles() == null) {
				addFieldError("news.images", getText("news.images.required"));
			}

		} catch (NullPointerException ne) {
		}
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getNewsId() {
		return newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

	public List<String> getTittles() {
		return tittles;
	}

	public void setTittles(List<String> tittles) {
		this.tittles = tittles;
	}

	public List<News> getNewses() {
		return newses;
	}

	public void setNewses(List<News> newses) {
		this.newses = newses;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

}
