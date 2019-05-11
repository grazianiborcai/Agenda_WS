package br.com.gda.business.customer.info;

import java.util.List;

import br.com.gda.info.obsolete.InfoWritterFactory_;

public final class CusKeeper extends InfoWritterFactory_<CusInfo> {	
	
	public CusKeeper() {
		super(new CusUniquifier());
	}
	
	
	
	@Override protected boolean isKeeperHook() {
		return super.ENABLED;
	}
	
	
	
	static public CusInfo keep(CusInfo sourceOne, CusInfo sourceTwo) {
		return new CusKeeperCus().keep(sourceOne, sourceTwo);
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<CusInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {	
		if (sourceOnes.get(0) instanceof CusInfo 	&&
			sourceTwos.get(0) instanceof CusInfo		)
			return new CusKeeperCus().keep((List<CusInfo>) sourceOnes, (List<CusInfo>) sourceTwos);
		
		
		return null;
	}
}
