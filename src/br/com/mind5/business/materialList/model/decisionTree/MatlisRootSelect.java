package br.com.mind5.business.materialList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.materialList.model.action.MatlisVisiMergeFimeco;
import br.com.mind5.business.materialList.model.action.MatlisVisiMergeMateg;
import br.com.mind5.business.materialList.model.action.MatlisVisiMergeMatext;
import br.com.mind5.business.materialList.model.action.MatlisVisiMergeMatoup;
import br.com.mind5.business.materialList.model.action.MatlisVisiMergeMatubup;
import br.com.mind5.business.materialList.model.action.MatlisVisiMergeMatunit;
import br.com.mind5.business.materialList.model.action.MatlisVisiMergeMatype;
import br.com.mind5.business.materialList.model.action.MatlisVisiMergeToSelect;
import br.com.mind5.business.materialList.model.checker.MatlisCheckLangu;
import br.com.mind5.business.materialList.model.checker.MatlisCheckOwner;
import br.com.mind5.business.materialList.model.checker.MatlisCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class MatlisRootSelect extends DeciTreeTemplateRead<MatlisInfo> {
	
	public MatlisRootSelect(DeciTreeOption<MatlisInfo> option) {
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
		
		ActionStd<MatlisInfo> select = new ActionStdCommom<MatlisInfo>(option, MatlisVisiMergeToSelect.class);
		ActionLazy<MatlisInfo> mergeMatype = new ActionLazyCommom<MatlisInfo>(option, MatlisVisiMergeMatype.class);
		ActionLazy<MatlisInfo> mergeMateg = new ActionLazyCommom<MatlisInfo>(option, MatlisVisiMergeMateg.class);
		ActionLazy<MatlisInfo> mergeMatoup = new ActionLazyCommom<MatlisInfo>(option, MatlisVisiMergeMatoup.class);
		ActionLazy<MatlisInfo> mergeMatubup = new ActionLazyCommom<MatlisInfo>(option, MatlisVisiMergeMatubup.class);
		ActionLazy<MatlisInfo> mergeMatunit = new ActionLazyCommom<MatlisInfo>(option, MatlisVisiMergeMatunit.class);
		ActionLazy<MatlisInfo> mergeMatext = new ActionLazyCommom<MatlisInfo>(option, MatlisVisiMergeMatext.class);
		ActionLazy<MatlisInfo> mergeFimeco = new ActionLazyCommom<MatlisInfo>(option, MatlisVisiMergeFimeco.class);
		
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
