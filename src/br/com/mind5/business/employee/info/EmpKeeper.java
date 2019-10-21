package br.com.mind5.business.employee.info;

import java.util.List;

import br.com.mind5.info.obsolete.InfoWritterFactory_;

public final class EmpKeeper extends InfoWritterFactory_<EmpInfo> {	
	
	public EmpKeeper() {
		super(new EmpUniquifier());
	}
	
	
	
	@Override protected boolean isKeeperHook() {
		return super.ENABLED;
	}
	
	
	
	static public EmpInfo keep(EmpInfo sourceOne, EmpInfo sourceTwo) {
		return new EmpKeeperEmp().keep(sourceOne, sourceTwo);
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<EmpInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {	
		if (sourceOnes.get(0) instanceof EmpInfo 	&&
			sourceTwos.get(0) instanceof EmpInfo		)
			return new EmpKeeperEmp().keep((List<EmpInfo>) sourceOnes, (List<EmpInfo>) sourceTwos);
		
		
		return null;
	}
}
