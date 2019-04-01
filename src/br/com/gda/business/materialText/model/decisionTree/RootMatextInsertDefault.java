package br.com.gda.business.materialText.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.materialText.info.MatextInfo;
import br.com.gda.business.materialText.model.action.LazyMatextRootInsert;
import br.com.gda.business.materialText.model.action.StdMatextEnforceDefaultOn;
import br.com.gda.business.materialText.model.checker.MatextCheckWrite;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootMatextInsertDefault extends DeciTreeWriteTemplate<MatextInfo> {
	
	public RootMatextInsertDefault(DeciTreeOption<MatextInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatextInfo> buildDecisionCheckerHook(DeciTreeOption<MatextInfo> option) {
		List<ModelChecker<MatextInfo>> queue = new ArrayList<>();		
		ModelChecker<MatextInfo> checker;	
		
		checker = new MatextCheckWrite();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatextInfo>> buildActionsOnPassedHook(DeciTreeOption<MatextInfo> option) {
		List<ActionStd<MatextInfo>> actions = new ArrayList<>();		
		
		ActionStd<MatextInfo> enforceDefaultOn = new StdMatextEnforceDefaultOn(option);	
		ActionLazy<MatextInfo> rootInsert = new LazyMatextRootInsert(option.conn, option.schemaName);
		
		enforceDefaultOn.addPostAction(rootInsert);
		
		actions.add(enforceDefaultOn);
		return actions;
	}
}
