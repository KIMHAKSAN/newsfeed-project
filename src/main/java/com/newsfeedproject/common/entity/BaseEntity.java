package com.newsfeedproject.common.entity;

import java.time.LocalDateTime;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

@Getter
@MappedSuperclass
public abstract class BaseEntity {

	@Comment("생성일")
	@Column(
		name = "created_at",
		nullable = false
	)
	@CreatedDate
	private LocalDateTime createdAt;

	@Comment("수정일")
	@Column(
		name = "updated_at",
		nullable = false
	)
	@LastModifiedDate
	private LocalDateTime updatedAt;

	@Comment("삭제 여부")
	@ColumnDefault("0")
	@Column(
		name = "is_deleted",
		nullable = false
	)
	private Integer isDeleted = 0;

	@Comment("삭제일")
	@Column(
		name = "deleted_at"
	)
	@LastModifiedDate
	private LocalDateTime deletedAt;

	protected BaseEntity() {
	}

	public void markAsDeleted() {
		this.isDeleted = 1;
		this.deletedAt = LocalDateTime.now();
	}
}
