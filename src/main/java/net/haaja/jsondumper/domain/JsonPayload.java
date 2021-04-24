package net.haaja.jsondumper.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payloads")
public class JsonPayload {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private Long userId;

  @Column(name = "content")
  private String content;

  @Column(name = "receivetime")
  private Long receiveTime;

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Long getReceiveTime() {
    return receiveTime;
  }

  public void setReceiveTime(Long receiveTime) {
    this.receiveTime = receiveTime;
  }
}
