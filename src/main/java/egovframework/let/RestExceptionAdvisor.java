package egovframework.let;

import javax.validation.ConstraintViolationException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import egovframework.com.cmm.ResponseCode;
import egovframework.com.cmm.service.ResultVO;

@RestControllerAdvice
public class RestExceptionAdvisor {

  @ExceptionHandler(ConstraintViolationException.class)
  public ResultVO processValidtionError(ConstraintViolationException exception) {
    ResultVO resultVO = new ResultVO();
    resultVO.setResultCode(ResponseCode.INPUT_CHECK_ERROR.getCode());
    resultVO.setResultMessage(exception.getMessage());

    return resultVO;
  }

  @ExceptionHandler(Exception.class) 
  public ResultVO elseError(Exception exception) {
    ResultVO resultVO = new ResultVO();
    resultVO.setResultCode(ResponseCode.INPUT_CHECK_ERROR.getCode());
    resultVO.setResultMessage(exception.getMessage());

    return resultVO;
  }
}
