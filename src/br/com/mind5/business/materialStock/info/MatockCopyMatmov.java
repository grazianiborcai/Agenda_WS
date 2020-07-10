package br.com.mind5.business.materialStock.info;

import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class MatockCopyMatmov extends InfoCopierTemplate<MatockInfo, MatmovInfo> {
	
	public MatockCopyMatmov() {
		super();
	}
	
	
	
	@Override protected MatockInfo makeCopyHook(MatmovInfo source) {
		MatockInfo result = new MatockInfo();
		result.codOwner = source.codOwner;
		result.codStore = source.codStore;
		result.codMat = source.codMat;
		result.codMatmovType = source.codMatmovType;
		result.quantityToUpdate = source.quantity;
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		return result;
	}
}
