package br.com.gda.business.company.info;

import java.util.List;

import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.security.username.info.UsernameInfo;

public final class CompMerger extends InfoWritterFactory_<CompInfo> {	
	
	public CompMerger() {
		super();
	}
	
	
	
	static public CompInfo merge(CompInfo sourceOne, CompInfo sourceTwo) {
		return new CompMergerToDelete().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public CompInfo merge(UsernameInfo sourceOne, CompInfo sourceTwo) {
		return new CompMergerUsername().merge(sourceOne, sourceTwo);
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<CompInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {	
		if (sourceOnes.get(0) instanceof CompInfo 	&&
			sourceTwos.get(0) instanceof CompInfo		)
			return new CompMergerToDelete().merge((List<CompInfo>) sourceOnes, (List<CompInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof UsernameInfo 	&&
			sourceTwos.get(0) instanceof CompInfo		)
			return new CompMergerUsername().merge((List<UsernameInfo>) sourceOnes, (List<CompInfo>) sourceTwos);
		
		
		return null;
	}
}
