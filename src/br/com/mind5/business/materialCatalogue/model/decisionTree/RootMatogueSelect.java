package br.com.mind5.business.materialCatalogue.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialCatalogue.info.MatogueInfo;
import br.com.mind5.business.materialCatalogue.model.action.LazyMatogueEnforceMatubup;
import br.com.mind5.business.materialCatalogue.model.action.LazyMatogueObfuscateStolis;
import br.com.mind5.business.materialCatalogue.model.action.StdMatogueMergeMatore;
import br.com.mind5.business.materialCatalogue.model.checker.MatogueCheckLangu;
import br.com.mind5.business.materialCatalogue.model.checker.MatogueCheckOwner;
import br.com.mind5.business.materialCatalogue.model.checker.MatogueCheckRead;
import br.com.mind5.business.materialCatalogue.model.checker.MatogueCheckStore;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootMatogueSelect extends DeciTreeTemplateRead<MatogueInfo> {
	
	public RootMatogueSelect(DeciTreeOption<MatogueInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatogueInfo> buildCheckerHook(DeciTreeOption<MatogueInfo> option) {
		ModelCheckerOption checkerOption;
		List<ModelChecker<MatogueInfo>> queue = new ArrayList<>();		
		ModelChecker<MatogueInfo> checker;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new MatogueCheckRead(checkerOption);
		queue.add(checker);		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatogueCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatogueCheckLangu(checkerOption);
		queue.add(checker);		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatogueCheckStore(checkerOption);
		queue.add(checker);	

		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatogueInfo>> buildActionsOnPassedHook(DeciTreeOption<MatogueInfo> option) {
		List<ActionStd<MatogueInfo>> actions = new ArrayList<>();
		
		ActionStd<MatogueInfo> mergeMatore = new StdMatogueMergeMatore(option);
		ActionLazy<MatogueInfo> enforceMatubup = new LazyMatogueEnforceMatubup(option.conn, option.schemaName);
		ActionLazy<MatogueInfo> obfuscateStolis = new LazyMatogueObfuscateStolis(option.conn, option.schemaName);
		
		mergeMatore.addPostAction(enforceMatubup);
		enforceMatubup.addPostAction(obfuscateStolis);
		
		actions.add(mergeMatore);		
		return actions;
	}
}
