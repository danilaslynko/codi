package ru.mtuci.codi.common;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class BaseService<T extends BaseData> {

    private BaseRepo<T> repo;

    public T create(T item) {
        this.repo.save(item);
        return item;
    }

    public T getById(Integer id) {
        T item = this.repo.findById(id).orElseThrow(() -> {
            return new RuntimeException();
        });
        return item;
    }

    public T change(T source){
        T target = this.getById(source.getId());
        this.repo.save(target);
        return target;
    }

    public void deleteById(Integer id){
        this.repo.deleteById(id);
    }

}
