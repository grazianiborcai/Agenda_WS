package br.com.gda.business.cartItem.info;

import br.com.gda.business.feeDefault.info.FeeDefaultInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class CartemMergerFeeDefault extends InfoMergerTemplate<CartemInfo, FeeDefaultInfo> {

	@Override protected InfoMergerVisitorV2<CartemInfo, FeeDefaultInfo> getVisitorHook() {
		return new CartemVisiMergeFeeDefault();
	}
	
	
	
	@Override protected InfoUniquifier<CartemInfo> getUniquifierHook() {
		return new CartemUniquifier();
	}
}
