package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import javax.annotation.meta.When;

public class TrainSensorTest {

    TrainUser user;
    TrainController controller;
    TrainSensorImpl sensor;
    @Before
    public void before() {
        user = mock(TrainUser.class);
        controller = mock(TrainController.class);

        sensor = new TrainSensorImpl(controller, user);
    }

    @Test
    public void TulGyors() {

        when(controller.getReferenceSpeed()).thenReturn(100);

        boolean res = sensor.overrideSpeedLimit(501);

        verify(controller, times(1)).getReferenceSpeed();
        assertEquals(true, res);
    }

    @Test
    public void TulLassu() {

        when(controller.getReferenceSpeed()).thenReturn(100);

        boolean res = sensor.overrideSpeedLimit(-1);

        verify(controller, times(1)).getReferenceSpeed();
        assertEquals(true, res);
    }

    @Test
    public void TulNagyKulonbseg() {

        when(controller.getReferenceSpeed()).thenReturn(150);

        boolean res = sensor.overrideSpeedLimit(50);

        verify(controller, times(1)).getReferenceSpeed();
        assertEquals(true, res);
    }

    @Test
    public void Rendben() {

        when(controller.getReferenceSpeed()).thenReturn(150);

        boolean res = sensor.overrideSpeedLimit(100);

        verify(controller, times(1)).getReferenceSpeed();
        assertEquals(false, res);
    }
}
