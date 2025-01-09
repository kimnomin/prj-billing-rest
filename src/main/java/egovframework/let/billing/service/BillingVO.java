package egovframework.let.billing.service;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class BillingVO implements Serializable {
  private int sn;
  @NotBlank(message = "설명은 필수 입력 항목입니다.")
  private String expln;
  @Min(value = 1, message = "사용금액은 1원 이상어이야 합니다.")
  private long useAmt; 
  @NotBlank(message = "사용일자는 필수 입력 항목입니다.")
  @Pattern(regexp = "(20)\\d{2}[0-1]\\d[0-3]\\d", message = "날짜(YYYYMMDD) 형태로 입력해야 합니다.")
  private String useYmd;
  private char prcsYn = 'N';
  private LocalDateTime prcsDt;
}
