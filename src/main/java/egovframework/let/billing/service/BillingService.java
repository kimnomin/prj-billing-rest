package egovframework.let.billing.service;

import java.util.List;

public interface BillingService {
  List<BillingVO> selectList();

  List<BillingVO> selectStats(String year);

  int insert(BillingVO vo);

  int updatePrcs(int sn);
}
