package br.com.gda.business.owner.info;

import java.util.List;

import br.com.gda.info.obsolete.InfoWritterFactory_;

public final class OwnerKeeper extends InfoWritterFactory_<OwnerInfo> {	
	
	public OwnerKeeper() {
		super(new OwnerUniquifier());
	}
	
	
	
	@Override protected boolean isKeeperHook() {
		return super.ENABLED;
	}
	
	
	
	static public OwnerInfo keep(OwnerInfo sourceOne, OwnerInfo sourceTwo) {
		return new OwnerKeeperOwner().keep(sourceOne, sourceTwo);
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<OwnerInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {	
		if (sourceOnes.get(0) instanceof OwnerInfo 	&&
			sourceTwos.get(0) instanceof OwnerInfo		)
			return new OwnerKeeperOwner().keep((List<OwnerInfo>) sourceOnes, (List<OwnerInfo>) sourceTwos);
		
		
		return null;
	}
}
