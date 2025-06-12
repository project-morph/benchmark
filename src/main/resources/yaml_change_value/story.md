## Change value in kubernetes config (YAML)

Across the company, there are several similar services like web-service, api-service, and worker-service etc, each running different parts of the product but sharing a common deployment pattern.

Originally, all these services had resource settings like:

```yaml
resources:
  requests:
    cpu: "250m"
    memory: "512Mi"
  limits:
    cpu: "1"
    memory: "1Gi"
```

As usage patterns became clearer, the DevOps engineer noticed that many of these services were regularly hitting resource limits during peak load, leading to slower response times and occasional pod restarts.

To ensure better stability and performance, the engineer proposed increasing the resource allocations across all these deployments to:

```yaml
resources:
  requests:
    cpu: "500m"
    memory: "1Gi"
  limits:
    cpu: "2"
    memory: "2Gi"
```

This change gave each service more guaranteed resources and headroom, improving overall system reliability. After thorough testing in staging environments and monitoring metrics, the updated configs need to be rolled out company-wide, leading to smoother operation during high-traffic periods.
