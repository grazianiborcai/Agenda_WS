package br.com.mind5.business.feeOwner.info;

import br.com.mind5.business.feeDefault.info.FeedefInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;

final class FeewnerMergerFeedef extends InfoMergerTemplate<FeewnerInfo, FeedefInfo> {

	@Override protected InfoMergerVisitor<FeewnerInfo, FeedefInfo> getVisitorHook() {
		return new FeewnerVisiMergeFeedef();
	}
}
