package br.com.mind5.business.materialStore.info;
import br.com.mind5.business.materialGroupStore.info.MatoporeInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class MatoreCopyMatopore extends InfoCopierTemplate<MatoreInfo, MatoporeInfo> {
	
	public MatoreCopyMatopore() {
		super();
	}
	
	
	
	@Override protected MatoreInfo makeCopyHook(MatoporeInfo source) {
		MatoreInfo result = new MatoreInfo();
		
		result.codOwner = source.codOwner;
		result.codStore = source.codStore;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
