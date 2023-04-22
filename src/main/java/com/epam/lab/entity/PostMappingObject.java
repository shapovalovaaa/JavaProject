package com.epam.lab.entity;

import com.epam.lab.validators.ValidationParamError;

import java.util.LinkedList;
import java.util.List;

public class PostMappingObject {
    private List<ValidationParamError> allObjects = new LinkedList<>();
    private Double sum;
    private Double minResult;
    private Double maxResult;

    private Double medianResult;
    public PostMappingObject(List<ValidationParamError> allObjects, Double sum,
                             Double minResult, Double maxResult, Double medianResult) {
        this.allObjects = allObjects;
        this.sum = sum;
        this.minResult = minResult;
        this.maxResult = maxResult;
        this.medianResult = medianResult;
    }

    public List<ValidationParamError> getAllObjects() {
        return allObjects;
    }

    public void setAllObjects(List<ValidationParamError> allObjects) {
        this.allObjects = allObjects;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public Double getMinResult() {
        return minResult;
    }

    public void setMinResult(Double minResult) {
        this.minResult = minResult;
    }

    public Double getMaxResult() {
        return maxResult;
    }

    public void setMaxResult(Double maxResult) {
        this.maxResult = maxResult;
    }
    public Double getMedianResult() {
        return medianResult;
    }

    public void setMedianResult(Double medianResult) {
        this.medianResult = medianResult;
    }
}
