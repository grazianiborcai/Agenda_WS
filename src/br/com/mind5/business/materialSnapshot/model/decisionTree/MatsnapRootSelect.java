package br.com.mind5.business.materialSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.business.materialSnapshot.model.action.MatsnapVisiMergeMateg;
import br.com.mind5.business.materialSnapshot.model.action.MatsnapVisiMergeMatextsnap;
import br.com.mind5.business.materialSnapshot.model.action.MatsnapVisiMergeMatoup;
import br.com.mind5.business.materialSnapshot.model.action.MatsnapVisiMergeMatubup;
import br.com.mind5.business.materialSnapshot.model.action.MatsnapVisiMergeMatunit;
import br.com.mind5.business.materialSnapshot.model.action.MatsnapVisiMergeMatype;
import br.com.mind5.business.materialSnapshot.model.action.MatsnapVisiMergeToSelect;
import br.com.mind5.business.materialSnapshot.model.checker.MatsnapCheckMat;
import br.com.mind5.business.materialSnapshot.model.checker.MatsnapCheckOwner;
import br.com.mind5.business.materialSnapshot.model.checker.MatsnapCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class MatsnapRootSelect extends DeciTreeTemplateRead<MatsnapInfo> {
	
	public MatsnapRootSelect(DeciTreeOption<MatsnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatsnapInfo> buildCheckerHook(DeciTreeOption<MatsnapInfo> option) {
		List<ModelChecker<MatsnapInfo>> queue = new ArrayList<>();		
		ModelChecker<MatsnapInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatsnapCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new MatsnapCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new MatsnapCheckMat(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatsnapInfo>> buildActionsOnPassedHook(DeciTreeOption<MatsnapInfo> option) {
		List<ActionStd<MatsnapInfo>> actions = new ArrayList<>();
		
		ActionStd<MatsnapInfo> select = new ActionStdCommom<MatsnapInfo>(option, MatsnapVisiMergeToSelect.class);
		ActionLazy<MatsnapInfo> mergeMatextsnap = new ActionLazyCommom<MatsnapInfo>(option, MatsnapVisiMergeMatextsnap.class);
		ActionLazy<MatsnapInfo> mergeMatype = new ActionLazyCommom<MatsnapInfo>(option, MatsnapVisiMergeMatype.class);
		ActionLazy<MatsnapInfo> mergeMateg = new ActionLazyCommom<MatsnapInfo>(option, MatsnapVisiMergeMateg.class);
		ActionLazy<MatsnapInfo> mergeMatoup = new ActionLazyCommom<MatsnapInfo>(option, MatsnapVisiMergeMatoup.class);
		ActionLazy<MatsnapInfo> mergeMatubup = new ActionLazyCommom<MatsnapInfo>(option, MatsnapVisiMergeMatubup.class);
		ActionLazy<MatsnapInfo> mergeMatunit = new ActionLazyCommom<MatsnapInfo>(option, MatsnapVisiMergeMatunit.class);
		
		select.addPostAction(mergeMatextsnap);
		mergeMatextsnap.addPostAction(mergeMatype);
		mergeMatype.addPostAction(mergeMateg);
		mergeMateg.addPostAction(mergeMatoup);
		mergeMatoup.addPostAction(mergeMatubup);
		mergeMatubup.addPostAction(mergeMatunit);
		
		actions.add(select);
		return actions;
	}
}
