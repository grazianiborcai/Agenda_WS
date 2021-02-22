package br.com.mind5.business.home.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.home.info.HomeInfo;
import br.com.mind5.business.home.model.action.LazyHomeMergeCartou;
import br.com.mind5.business.home.model.action.LazyHomeMergeUsome;
import br.com.mind5.business.home.model.action.StdHomeMergeUsername;
import br.com.mind5.business.home.model.checker.HomeCheckLangu;
import br.com.mind5.business.home.model.checker.HomeCheckOwner;
import br.com.mind5.business.home.model.checker.HomeCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootHomeSelect extends DeciTreeTemplateRead<HomeInfo> {
	
	public RootHomeSelect(DeciTreeOption<HomeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<HomeInfo> buildCheckerHook(DeciTreeOption<HomeInfo> option) {
		List<ModelChecker<HomeInfo>> queue = new ArrayList<>();		
		ModelChecker<HomeInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new HomeCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new HomeCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new HomeCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<HomeInfo>> buildActionsOnPassedHook(DeciTreeOption<HomeInfo> option) {
		List<ActionStd<HomeInfo>> actions = new ArrayList<>();		
		
		ActionStd<HomeInfo> mergeUser = new StdHomeMergeUsername(option);
		ActionLazy<HomeInfo> mergeCartou = new LazyHomeMergeCartou(option.conn, option.schemaName);
		ActionLazy<HomeInfo> mergeUsome = new LazyHomeMergeUsome(option.conn, option.schemaName);
		
		mergeUser.addPostAction(mergeCartou);
		mergeCartou.addPostAction(mergeUsome);
		
		actions.add(mergeUser);	
		return actions;
	}
}
