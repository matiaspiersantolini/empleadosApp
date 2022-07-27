package fabrica.empleados.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Slf4j
@Aspect
@Component
public class InicioFinLogAspect {


    /**
     * Log de inicio y fin del api.
     */
    @Around("@annotation(fabrica.empleados.aspect.annotations.InicioFinLog)")
    public Object inicioLog(ProceedingJoinPoint joinPoint) throws Throwable {
        String dateTime = new SimpleDateFormat("yyyy-MM-dd' 'HH:mm:ss").format(Calendar.getInstance().getTime());

        log.info("[INICIO] Ingresando al controller de EmpleadosApp... [{}]", dateTime);

        Object proceed = joinPoint.proceed();

        log.info("[FIN] Ejecucion exitosa...");
        return proceed;
    }
}
