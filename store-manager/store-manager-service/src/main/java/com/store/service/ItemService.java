package com.store.service;

import com.store.common.pojo.EUDataGridResult;
import com.store.pojo.TbItem;

public interface ItemService {
    public TbItem getItemById(long itemId);

    public EUDataGridResult getItemList(int page, int rows);
}
