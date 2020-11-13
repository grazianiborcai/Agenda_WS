package br.com.mind5.business.material.model.checker;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.masterData.materialType.info.MatypeInfo;
import br.com.mind5.masterData.materialType.model.checker.MatypeCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class MatCheckMatype extends ModelCheckerTemplateForward<MatInfo, MatypeInfo> {
	
	public MatCheckMatype(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<MatypeInfo> getCheckerHook(ModelCheckerOption option) {
		return new MatypeCheckExist(option);
	}
	
	
	
	@Override protected MatypeInfo toForwardClass(MatInfo baseRecord) {
		return MatypeInfo.copyFrom(baseRecord);
	}
}
