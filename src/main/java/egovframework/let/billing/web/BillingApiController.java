package egovframework.let.billing.web;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import egovframework.com.cmm.ResponseCode;
import egovframework.com.cmm.service.ResultVO;
import egovframework.let.billing.service.BillingService;
import egovframework.let.billing.service.BillingVO;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/billing")
@Validated
public class BillingApiController {

  @Resource(name = "billingService")
  private BillingService billingService;

  @GetMapping(value = "")
  public ResultVO selectList() {
    List<BillingVO> list = billingService.selectList();
    ResultVO resultVO = new ResultVO();

    resultVO.setData(list);
    resultVO.setResultCode(ResponseCode.SUCCESS.getCode());
    resultVO.setResultMessage(ResponseCode.SUCCESS.getMessage());

    return resultVO;
  }

  @GetMapping(value = "/stats")
  public ResultVO selectStats(@RequestParam String year) {
    List<BillingVO> list = billingService.selectStats(year);
    ResultVO resultVO = new ResultVO();
    
    resultVO.setData(list);
    resultVO.setResultCode(ResponseCode.SUCCESS.getCode());
    resultVO.setResultMessage(ResponseCode.SUCCESS.getMessage());

    return resultVO;
  }
  

  @PostMapping(value = "")
  public ResultVO insert(@RequestBody @Valid BillingVO vo, BindingResult bindingResult) {
    ResultVO resultVO = new ResultVO();
    int result = billingService.insert(vo);

    resultVO.setData(result);
    resultVO.setResultCode(ResponseCode.SUCCESS.getCode());
    resultVO.setResultMessage(ResponseCode.SUCCESS.getMessage());

    return resultVO;
  }

  @PatchMapping(value = "/{sn}")
  public ResultVO updatePrcs(@PathVariable int[] sn) {
    ResultVO resultVO = new ResultVO();
    if (sn.length <= 0) {
      resultVO.setResultCode(ResponseCode.INPUT_CHECK_ERROR.getCode());
      resultVO.setResultMessage(ResponseCode.INPUT_CHECK_ERROR.getMessage());
      return resultVO;
    }

    int resultCount = 0;
    for (int i : sn) {
      resultCount += billingService.updatePrcs(i);  
    }

    resultVO.setResultCode(ResponseCode.SUCCESS.getCode());
    if (resultCount <= 0) {
      resultVO.setResultMessage("수정된 데이터가 없습니다.");
    } else {
      resultVO.setResultMessage(ResponseCode.SUCCESS.getMessage());
    }   
    

    return resultVO;
  }
}
