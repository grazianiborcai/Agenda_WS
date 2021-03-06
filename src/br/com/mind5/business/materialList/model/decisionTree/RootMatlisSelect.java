package br.com.mind5.business.materialList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.materialList.model.action.LazyMatlisMergeFimeco;
import br.com.mind5.business.materialList.model.action.LazyMatlisMergeMateg;
import br.com.mind5.business.materialList.model.action.LazyMatlisMergeMatext;
import br.com.mind5.business.materialList.model.action.LazyMatlisMergeMatoup;
import br.com.mind5.business.materialList.model.action.LazyMatlisMergeMatubup;
import br.com.mind5.business.materialList.model.action.LazyMatlisMergeMatunit;
import br.com.mind5.business.materialList.model.action.LazyMatlisMergeMatype;
import br.com.mind5.business.materialList.model.action.StdMatlisMergeToSelect;
import br.com.mind5.business.materialList.model.checker.MatlisCheckLangu;
import br.com.mind5.business.materialList.model.checker.MatlisCheckOwner;
import br.com.mind5.business.materialList.model.checker.MatlisCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootMatlisSelect extends DeciTreeTemplateRead<MatlisInfo> {
	
	public RootMatlisSelect(DeciTreeOption<MatlisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatlisInfo> buildCheckerHook(DeciTreeOption<MatlisInfo> option) {
		List<ModelChecker<MatlisInfo>> queue = new ArrayList<>();		
		ModelChecker<MatlisInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatlisCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatlisCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatlisCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatlisInfo>> buildActionsOnPassedHook(DeciTreeOption<MatlisInfo> option) {
		List<ActionStd<MatlisInfo>> actions = new ArrayList<>();
		
		ActionStd<MatlisInfo> select = new StdMatlisMergeToSelect(option);
		ActionLazy<MatlisInfo> mergeMatype = new LazyMatlisMergeMatype(option.conn, option.schemaName);
		ActionLazy<MatlisInfo> mergeMateg = new LazyMatlisMergeMateg(option.conn, option.schemaName);
		ActionLazy<MatlisInfo> mergeMatoup = new LazyMatlisMergeMatoup(option.conn, option.schemaName);
		ActionLazy<MatlisInfo> mergeMatubup = new LazyMatlisMergeMatubup(option.conn, option.schemaName);
		ActionLazy<MatlisInfo> mergeMatunit = new LazyMatlisMergeMatunit(option.conn, option.schemaName);
		ActionLazy<MatlisInfo> mergeMatext = new LazyMatlisMergeMatext(option.conn, option.schemaName);
		ActionLazy<MatlisInfo> mergeFimeco = new LazyMatlisMergeFimeco(option.conn, option.schemaName);
		
		select.addPostAction(mergeMatype);
		mergeMatype.addPostAction(mergeMateg);
		mergeMateg.addPostAction(mergeMatoup);		
		mergeMatoup.addPostAction(mergeMatubup);		
		mergeMatubup.addPostAction(mergeMatunit);
		mergeMatunit.addPostAction(mergeMatext);
		mergeMatext.addPostAction(mergeFimeco); 
		
		actions.add(select);
		return actions;
	}
}
