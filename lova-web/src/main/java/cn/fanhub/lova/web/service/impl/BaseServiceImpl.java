/**
 *    Copyright 2018 chengfan(fanhub.cn)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.fanhub.lova.web.service.impl;

import cn.fanhub.lova.web.repository.BaseRepository;
import cn.fanhub.lova.web.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chengfan
 * @version $Id: BaseServiceImpl.java, v 0.1 2018年05月01日 下午5:52 chengfan Exp $
 */
public class BaseServiceImpl<T, ID extends Serializable> implements BaseService<T, ID> {

    @Autowired
    protected BaseRepository<T, ID> baseRepository;

    /**
     * Save t.
     *
     * @param t the t
     * @return the t
     */
    public T save(T t) {
        return baseRepository.save(t);
    }

    /**
     * Save iterable.
     *
     * @param <S>  the type parameter
     * @param iterable the iterable
     * @return the iterable
     */
    public <S extends T> Iterable<S> save(Iterable<S> iterable) {
        return baseRepository.save(iterable);
    }

    /**
     * Update t.
     *
     * @param t the t
     * @return the t
     */
    public T update(T t) {
        return baseRepository.save(t);
    }

    /**
     * Delete.
     *
     * @param t the t
     */
    public void delete(T t) {
        baseRepository.delete(t);
    }


    /**
     * Gets one.
     *
     * @param id the id
     * @return the one
     */
    public T getOne(ID id) {
        return baseRepository.findOne(id);
    }

    /**
     * Gets count.
     *
     * @return the count
     */
    public long getCount() {
        return baseRepository.count();
    }

    /**
     * Gets all.
     *
     * @return the all
     */
    public List<T> getAll() {
        return baseRepository.findAll();
    }

    /**
     * Gets all.
     *
     * @param ids the ids
     * @return the all
     */
    public List<T> getAll(List<ID> ids) {
        return new ArrayList<T>(baseRepository.findAll(ids));
    }
}
