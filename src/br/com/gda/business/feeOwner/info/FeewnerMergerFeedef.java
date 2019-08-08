package br.com.gda.business.feeOwner.info;

import br.com.gda.business.feeDefault.info.FeedefInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;

final class FeewnerMergerFeedef extends InfoMergerTemplate<FeewnerInfo, FeedefInfo> {

	@Override protected InfoMergerVisitor<FeewnerInfo, FeedefInfo> getVisitorHook() {
		return new FeewnerVisiMergeFeedef();
	}
}
