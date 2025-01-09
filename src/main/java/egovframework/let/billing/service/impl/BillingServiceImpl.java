package egovframework.let.billing.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.stereotype.Service;

import egovframework.let.billing.service.BillingService;
import egovframework.let.billing.service.BillingVO;

@Service("billingService")
public class BillingServiceImpl extends EgovAbstractServiceImpl implements BillingService {

  @Resource(name = "billingDAO")
  private BillingDAO billingDAO;

  @Override
  public List<BillingVO> selectList() {
    return billingDAO.selectList();
  }

  @Override
  public List<BillingVO> selectStats(String year) {
    return billingDAO.selectStats(year);
  }

  @Override
  public int insert(BillingVO vo) {
    return billingDAO.insert(vo);
  }

  @Override
  public int updatePrcs(int sn) {
    return billingDAO.updatePrcs(sn);
  }
}
