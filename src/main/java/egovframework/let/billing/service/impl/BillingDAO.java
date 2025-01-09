package egovframework.let.billing.service.impl;

import java.util.List;

import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;
import org.springframework.stereotype.Repository;

import egovframework.let.billing.service.BillingVO;

@Repository("billingDAO")
public class BillingDAO extends EgovAbstractMapper {
  public List<BillingVO> selectList() {
    return selectList("BillingDAO.selectList");
  }

  public List<BillingVO> selectStats(String year) {
    return selectList("BillingDAO.selectStats", year);
  }

  public int insert(BillingVO vo) {
    return insert("BillingDAO.insert", vo);
  }

  public int updatePrcs(int sn) {
    return update("BillingDAO.updatePrcs", sn);
  }
}
