package br.com.mind5.business.material.model.checker;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.masterData.materialSubgroup.info.MatubupInfo;
import br.com.mind5.masterData.materialSubgroup.model.checker.MatubupCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class MatCheckMatubup extends ModelCheckerTemplateForward<MatInfo, MatubupInfo> {
	
	public MatCheckMatubup(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<MatubupInfo> getCheckerHook(ModelCheckerOption option) {
		return new MatubupCheckExist(option);
	}
	
	
	
	@Override protected MatubupInfo toForwardClass(MatInfo baseRecord) {
		return MatubupInfo.copyFrom(baseRecord);
	}
}
