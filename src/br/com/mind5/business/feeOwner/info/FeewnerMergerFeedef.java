package br.com.mind5.business.feeOwner.info;

import br.com.mind5.business.feeDefault.info.FeedefInfo;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class FeewnerMergerFeedef extends InfoMergerTemplate_<FeewnerInfo, FeedefInfo> {

	@Override protected InfoMergerVisitor_<FeewnerInfo, FeedefInfo> getVisitorHook() {
		return new FeewnerVisiMergeFeedef();
	}
}
