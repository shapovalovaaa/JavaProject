package com.epam.lab.entity;

import com.epam.lab.validators.ValidationParamError;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

public class PostMappingObjectTest {
    private PostMappingObject postMappingObj = mock(PostMappingObject.class);
    @Test
    void PostMappingObjSetGet() {
        Cylinder c1 = new Cylinder(1.1, 2.2);
        Cylinder c4 = new Cylinder(7.7, 1.1);

        Double expectedSumResult = 68.425;
        Double expectedMaxResult = 53.219;
        Double expectedMinResult = 15.206;
        Double expectedMedianResult = 34.213;

        List<ValidationParamError> expectedResultList = new LinkedList<>();
        expectedResultList.add(new ValidationParamError("", HttpStatus.OK, c1));
        expectedResultList.add(new ValidationParamError("Invalid argument", HttpStatus.BAD_REQUEST));
        expectedResultList.add(new ValidationParamError("Invalid argument", HttpStatus.BAD_REQUEST));
        expectedResultList.add(new ValidationParamError("", HttpStatus.OK, c4));

        PostMappingObject postMappingObject = new PostMappingObject();
        postMappingObject.setAllObjects(expectedResultList);
        postMappingObject.setMaxResult(53.219);
        postMappingObject.setMinResult(15.206);
        postMappingObject.setSum(68.425);
        postMappingObject.setMedianResult(34.213);

        doNothing().when(postMappingObj).setAllObjects(expectedResultList);
        doNothing().when(postMappingObj).setMaxResult(53.219);
        doNothing().when(postMappingObj).setMinResult(15.206);
        doNothing().when(postMappingObj).setMedianResult(34.213);
        doNothing().when(postMappingObj).setSum(68.425);
        postMappingObj.setAllObjects(expectedResultList);
        postMappingObj.setAllObjects(expectedResultList);
        postMappingObj.setMaxResult(53.219);
        postMappingObj.setMinResult(15.206);
        postMappingObj.setMedianResult(34.213);
        postMappingObj.setSum(68.425);
        verify(postMappingObj, times(2)).setAllObjects(expectedResultList);
        verify(postMappingObj, times(1)).setMaxResult(53.219);
        verify(postMappingObj, times(1)).setMinResult(15.206);
        verify(postMappingObj, times(1)).setMedianResult(34.213);
        verify(postMappingObj, times(1)).setSum(68.425);
        Assertions.assertEquals(expectedResultList, postMappingObject.getAllObjects());
        Assertions.assertEquals(expectedMaxResult, postMappingObject.getMaxResult());
        Assertions.assertEquals(expectedMinResult, postMappingObject.getMinResult());
        Assertions.assertEquals(expectedMedianResult, postMappingObject.getMedianResult());
        Assertions.assertEquals(expectedSumResult, postMappingObject.getSum());
    }
}
