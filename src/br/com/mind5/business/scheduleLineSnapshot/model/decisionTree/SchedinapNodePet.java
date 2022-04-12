package br.com.mind5.business.scheduleLineSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.mind5.business.scheduleLineSnapshot.model.action.SchedinapVisiMergePetlis;
import br.com.mind5.business.scheduleLineSnapshot.model.checker.SchedinapCheckHasPet;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.action.commom.ActionStdSuccessCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class SchedinapNodePet extends DeciTreeTemplateWrite<SchedinapInfo> {
	
	public SchedinapNodePet(DeciTreeOption<SchedinapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedinapInfo> buildCheckerHook(DeciTreeOption<SchedinapInfo> option) {
		List<ModelChecker<SchedinapInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedinapInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SchedinapCheckHasPet(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SchedinapInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedinapInfo> option) {
		List<ActionStd<SchedinapInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedinapInfo> mergePetlis = new ActionStdCommom<SchedinapInfo>(option, SchedinapVisiMergePetlis.class);
		
		actions.add(mergePetlis);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<SchedinapInfo>> buildActionsOnFailedHook(DeciTreeOption<SchedinapInfo> option) {
		List<ActionStd<SchedinapInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedinapInfo> success = new ActionStdSuccessCommom<SchedinapInfo>(option);
		
		actions.add(success);
		return actions;
	}
}
