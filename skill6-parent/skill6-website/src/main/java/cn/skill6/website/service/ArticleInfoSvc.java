package cn.skill6.website.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy.SnakeCaseStrategy;

import cn.skill6.common.entity.po.ArticleInfo;
import cn.skill6.common.entity.vo.restful.ResponseJson;
import cn.skill6.common.exception.Skill6Exception;
import cn.skill6.website.impl.ArticleInfoImpl;

/**
 * TODO
 *
 * @author 何明胜
 * @created at 2018年8月16日 下午11:05:49
 * @version 1.0.0
 */
@Service
public class ArticleInfoSvc {
  private final ObjectMapper objectMapper = new ObjectMapper();

  @Autowired private ArticleInfoImpl articleInfoImpl;

  public ResponseJson addArticle(Map<String, String> jsonMap) throws Skill6Exception, IOException {
    ResponseJson responseJson;

    String jsonStr = objectMapper.writeValueAsString(jsonMap);
    objectMapper.setPropertyNamingStrategy(SnakeCaseStrategy.SNAKE_CASE);
    ArticleInfo articleInfo = objectMapper.readValue(jsonStr, ArticleInfo.class);

    try {
      Long articleId = articleInfoImpl.addArticleInfo(articleInfo);
      responseJson = new ResponseJson(true, String.valueOf(articleId));
    } catch (Exception e) {
      responseJson = new ResponseJson(false, "注册失败");
    }

    return responseJson;
  }

  public ResponseJson deleteArticleById(Long articleId) throws Skill6Exception {
    articleInfoImpl.deleteByPrimaryKey(articleId);

    return new ResponseJson(true, "删除成功");
  }

  public ResponseJson modifyByArticleId(Map<String, String> jsonMap)
      throws Skill6Exception, IOException {
    ResponseJson responseJson;

    String jsonStr = objectMapper.writeValueAsString(jsonMap);
    objectMapper.setPropertyNamingStrategy(SnakeCaseStrategy.SNAKE_CASE);
    ArticleInfo articleInfo = objectMapper.readValue(jsonStr, ArticleInfo.class);

    try {
      articleInfoImpl.modifyByArticleId(articleInfo);
      responseJson = new ResponseJson(false, "修改成功");
    } catch (Exception e) {
      responseJson = new ResponseJson(false, "修改失败");
    }

    return responseJson;
  }

  public ArticleInfo getArticleById(Long articleId) throws Skill6Exception {
    return articleInfoImpl.findByArticleId(articleId);
  }

  public List<ArticleInfo> getAllArticles() {
    return articleInfoImpl.findAll();
  }
}