package com.github.nishant141077.sors.models.transaction;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction {

  private String transactionId;

  @NotNull
  private TransactionType type;

  @NotBlank
  private String investmentId;

  @NotBlank
  private String goalId;

  private String platform;

  @Min(1)
  private double amount;

  @NotNull
  private Date transactionTime;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "IST")
  private Date createdAt;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "IST")
  private Date updatedAt;
}
