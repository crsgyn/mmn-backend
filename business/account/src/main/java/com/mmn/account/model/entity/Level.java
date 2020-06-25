package com.mmn.account.model.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mmn.account.model.type.LevelStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Table(
		indexes = {
				@Index(columnList = "CHILD_ID", unique = true)
		})
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Level {
    // Id will be used for the invite of child
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    private Account parent;
    @ManyToOne
    @JoinColumn(name = "CHILD_ID")
    private Account child;
    @Builder.Default
    @Enumerated(EnumType.STRING)
    private LevelStatus status = LevelStatus.Inactive;
    private Integer score;
    private LocalDate activeDate;
    private String emailInvited; //same to account child.to

    public boolean isActive() {
        return this.score.equals(LevelStatus.Active);
    }

}
