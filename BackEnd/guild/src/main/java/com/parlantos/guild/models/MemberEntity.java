package com.parlantos.guild.models;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "member")
public class MemberEntity {

  @Column(name = "id")
  @Id
  private BigInteger id;

  @Column(name = "username")
  private String username;

  @Column(name = "password")
  private String password;

  @Column(name = "salt")
  private String salt;

  @Column(name = "display_name")
  private String displayName;

  @Column(name = "name_tag")
  private String nameTag;

  @Column(name = "created_at")
  private LocalDateTime createdAt;

  @Column(name = "email")
  private String email;

  @OneToMany(mappedBy = "member")
  private List<FriendEntity> friendEntityList;

  @OneToMany(mappedBy = "member")
  private List<MessageEntity> messageEntityList;

  @OneToMany(mappedBy = "member")
  private List<ReplyEntity> replyEntityList;

  @OneToMany(mappedBy = "member")
  private List<GuildMemberEntity> guildMemberEntityList;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    MemberEntity that = (MemberEntity) o;
    return id.equals(that.id) && Objects.equals(username, that.username) && Objects.equals(password, that.password) && Objects.equals(salt, that.salt) && Objects.equals(displayName, that.displayName) && Objects.equals(nameTag, that.nameTag) && Objects.equals(createdAt, that.createdAt) && Objects.equals(email, that.email) && Objects.equals(friendEntityList, that.friendEntityList) && Objects.equals(messageEntityList, that.messageEntityList) && Objects.equals(replyEntityList, that.replyEntityList) && Objects.equals(guildMemberEntityList, that.guildMemberEntityList) && Objects.equals(oktaId, that.oktaId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, username, password, salt, displayName, nameTag, createdAt, email, friendEntityList, messageEntityList, replyEntityList, guildMemberEntityList, oktaId);
  }

  public List<FriendEntity> getFriendEntityList() {
    return friendEntityList;
  }

  public void setFriendEntityList(List<FriendEntity> friendEntityList) {
    this.friendEntityList = friendEntityList;
  }

  public List<MessageEntity> getMessageEntityList() {
    return messageEntityList;
  }

  public void setMessageEntityList(List<MessageEntity> messageEntityList) {
    this.messageEntityList = messageEntityList;
  }

  public List<ReplyEntity> getReplyEntityList() {
    return replyEntityList;
  }

  public void setReplyEntityList(List<ReplyEntity> replyEntityList) {
    this.replyEntityList = replyEntityList;
  }

  public List<GuildMemberEntity> getGuildMemberEntityList() {
    return guildMemberEntityList;
  }

  public void setGuildMemberEntityList(List<GuildMemberEntity> guildMemberEntityList) {
    this.guildMemberEntityList = guildMemberEntityList;
  }

  public BigInteger getId() {
    return id;
  }

  public void setId(BigInteger id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getSalt() {
    return salt;
  }

  public void setSalt(String salt) {
    this.salt = salt;
  }

  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public String getNameTag() {
    return nameTag;
  }

  public void setNameTag(String nameTag) {
    this.nameTag = nameTag;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getOktaId() {
    return oktaId;
  }

  public void setOktaId(String oktaId) {
    this.oktaId = oktaId;
  }

  @Column(name = "okta_id")
  private String oktaId;
}
