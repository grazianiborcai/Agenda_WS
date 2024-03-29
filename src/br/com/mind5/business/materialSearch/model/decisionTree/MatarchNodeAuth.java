package br.com.mind5.business.materialSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialSearch.info.MatarchInfo;
import br.com.mind5.business.materialSearch.model.action.MatarchVisiObfuscateCodStore;
import br.com.mind5.business.materialSearch.model.checker.MatarchCheckSytotin;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.action.commom.ActionStdSuccessCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class MatarchNodeAuth extends DeciTreeTemplateRead<MatarchInfo> {
	
	public MatarchNodeAuth(DeciTreeOption<MatarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatarchInfo> buildCheckerHook(DeciTreeOption<MatarchInfo> option) {
		List<ModelChecker<MatarchInfo>> queue = new ArrayList<>();		
		ModelChecker<MatarchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new MatarchCheckSytotin(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatarchInfo>> buildActionsOnPassedHook(DeciTreeOption<MatarchInfo> option) {
		List<ActionStd<MatarchInfo>> actions = new ArrayList<>();
		
		ActionStd<MatarchInfo> success = new ActionStdSuccessCommom<MatarchInfo>(option);
		
		actions.add(success);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<MatarchInfo>> buildActionsOnFailedHook(DeciTreeOption<MatarchInfo> option) {
		List<ActionStd<MatarchInfo>> actions = new ArrayList<>();
		
		ActionStd<MatarchInfo> obfuscateCodStore = new ActionStdCommom<MatarchInfo>(option, MatarchVisiObfuscateCodStore.class);
		
		actions.add(obfuscateCodStore);
		return actions;
	}
}
